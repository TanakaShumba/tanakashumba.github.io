import socket

# Simple ethical hacking simulation: Port Scanning and Banner Grabbing
def scan_ports(target):
    common_ports = [21, 22, 23, 25, 53, 80, 443]
    for port in common_ports:
        try:
            sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
            sock.settimeout(1)
            result = sock.connect_ex((target, port))
            if result == 0:
                print(f"[+] Port {port} open on {target}")
            sock.close()
        except Exception as e:
            print(f"Error scanning port {port}: {e}")

def grab_banner(target, port):
    try:
        sock = socket.socket()
        sock.settimeout(1)
        sock.connect((target, port))
        banner = sock.recv(1024).decode().strip()
        print(f"[+] Banner for port {port}: {banner}")
        sock.close()
    except Exception as e:
        print(f"Error grabbing banner on port {port}: {e}")

if __name__ == "__main__":
    target = input("Enter target IP or hostname: ")
    scan_ports(target)
    print("\nBanner grabbing for open ports...")
    for port in [80, 22, 21]:
        grab_banner(target, port)
