import socket

def scan(host, ports):
    for port in ports:
        sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        sock.settimeout(0.5)
        result = sock.connect_ex((host, port))
        if result == 0:
            print(f"Port {port} is open on {host}")
        sock.close()

if __name__ == "__main__":
    host = input("Enter host to scan: ")
    ports = [21, 22, 23, 25, 53, 80, 443]
    scan(host, ports)
