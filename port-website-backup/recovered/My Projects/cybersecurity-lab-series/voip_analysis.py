from scapy.all import sniff, RTP

def packet_callback(packet):
    if packet.haslayer(RTP):
        rtp = packet[RTP]
        print(f"RTP Packet: Seq={rtp.seq}, Timestamp={rtp.time}, PayloadType={rtp.payload_type}")

print("Capturing RTP packets...")
sniff(filter="udp", prn=packet_callback, store=0)
