def extract_metadata(pkt):
    metadata = {}

    if pkt.haslayer("IP"):
        metadata["src_ip"] = pkt["IP"].src
        metadata["dst_ip"] = pkt["IP"].dst

    if pkt.haslayer("UDP"):
        metadata["src_port"] = pkt["UDP"].sport
        metadata["dst_port"] = pkt["UDP"].dport

    try:
        raw_data = bytes(pkt["UDP"].payload).decode(errors="ignore")
        if "SIP" in raw_data or "INVITE" in raw_data or "BYE" in raw_data:
            metadata["protocol"] = "SIP"
            lines = raw_data.split("\r\n")
            metadata["sip_summary"] = next((line for line in lines if any(x in line for x in ["INVITE", "BYE", "ACK", "SIP/"])), "SIP Packet")
        else:
            metadata["protocol"] = "OTHER"
    except Exception:
        metadata["protocol"] = "UNKNOWN"

    return metadata