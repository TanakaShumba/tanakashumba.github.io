from scapy.all import sniff, wrpcap, get_if_list, get_if_addr, conf
import os

def get_default_interface():
    interfaces = get_if_list()
    for iface in interfaces:
        try:
            ip = get_if_addr(iface)
            if ip != "0.0.0.0":
                print(f"[*] Selected interface: {iface} (IP: {ip})")
                return iface
        except Exception:
            continue
    raise RuntimeError("No suitable network interface found.")

def capture_voip_packets():
    iface = get_default_interface()
    bpf_filter = "udp or tcp port 5060"
    output_file = "data/captures/voip_traffic.pcap"
    os.makedirs(os.path.dirname(output_file), exist_ok=True)

    print(f"[*] Capturing packets on {iface} with filter: {bpf_filter}")
    try:
        packets = sniff(iface=iface, filter=bpf_filter, timeout=60)
        wrpcap(output_file, packets)
        print(f"[✔] Packets saved to {output_file}")
    except Exception as e:
        print(f"[!] Failed to capture packets: {e}")

if __name__ == "__main__":
    capture_voip_packets()
