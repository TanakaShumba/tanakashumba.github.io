from scapy.all import sniff, wrpcap, get_if_list
import os

def select_interface():
    interfaces = get_if_list()
    print("Available Interfaces:")
    for idx, iface in enumerate(interfaces):
        print(f"{idx + 1}: {iface}")

    choice = input("\nSelect the interface number to capture VoIP packets (e.g., 5): ")
    try:
        iface_index = int(choice) - 1
        if 0 <= iface_index < len(interfaces):
            return interfaces[iface_index]
        else:
            print("[!] Invalid selection. Defaulting to first interface.")
            return interfaces[0]
    except ValueError:
        print("[!] Invalid input. Defaulting to first interface.")
        return interfaces[0]

def capture_voip_packets():
    iface = select_interface()
    bpf_filter = "udp or tcp port 5060"
    output_file = "data/captures/voip_traffic.pcap"
    os.makedirs(os.path.dirname(output_file), exist_ok=True)

    print(f"\n[*] Capturing packets on {iface} with filter: {bpf_filter}")
    try:
        packets = sniff(iface=iface, filter=bpf_filter, timeout=60)
        wrpcap(output_file, packets)
        print(f"[✔] Packets saved to {output_file}")
    except Exception as e:
        print(f"[!] Failed to capture packets: {e}")

if __name__ == "__main__":
    print("[*] Script started.")
    capture_voip_packets()
