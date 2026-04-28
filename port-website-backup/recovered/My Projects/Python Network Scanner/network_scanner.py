import socket
from ipaddress import ip_network

def scan_host(ip, port_range=(1, 1024)):
    open_ports = []
    for port in range(port_range[0], port_range[1]+1):
        try:
            sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
            sock.settimeout(0.5)
            result = sock.connect_ex((ip, port))
            if result == 0:
                open_ports.append(port)
            sock.close()
        except Exception as e:
            pass
    return open_ports

def main():
    network = input("Enter network (e.g., 192.168.1.0/24): ")
    print(f"Scanning network: {network}...\n")
    
    for ip in ip_network(network).hosts():
        print(f"Scanning {ip}...")
        ports = scan_host(str(ip))
        if ports:
            print(f"  Open ports: {ports}")
        else:
            print("  No open ports found.")
        
if __name__ == "__main__":
    main()
