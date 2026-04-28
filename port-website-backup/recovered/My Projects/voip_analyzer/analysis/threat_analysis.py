def detect_threats(metadata_list):
    threats = []

    invite_count = 0
    bye_count = 0
    ip_activity = {}

    for md in metadata_list:
        src = md.get("src_ip")
        if src:
            ip_activity[src] = ip_activity.get(src, 0) + 1

        summary = md.get("sip_summary", "")
        if "INVITE" in summary:
            invite_count += 1
        if "BYE" in summary:
            bye_count += 1

    for ip, count in ip_activity.items():
        if count > 50:
            threats.append({"type": "High SIP Packet Rate", "details": f"{ip} sent {count} packets"})

    if invite_count > 0 and bye_count == 0:
        threats.append({"type": "Call Flood", "details": "INVITE packets seen without BYE responses"})

    if not threats:
        threats.append({"type": "Info", "details": "No SIP threats detected."})

    return threats