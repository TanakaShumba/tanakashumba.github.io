import json

logs = json.load(open("sample_logs.json"))

for log in logs:
    print(f"{log['timestamp']} - {log['source']} - {log['event']}")
