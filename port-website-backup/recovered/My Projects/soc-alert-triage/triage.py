import json

alerts = [
    {"id": 101, "type": "malware", "severity": "high"},
    {"id": 102, "type": "phishing", "severity": "medium"},
    {"id": 103, "type": "port scan", "severity": "low"}
]

for alert in alerts:
    action = "Investigate immediately" if alert["severity"] == "high" else "Monitor"
    print(f"Alert {alert['id']} ({alert['type']}) - Severity: {alert['severity']} - Action: {action}")
