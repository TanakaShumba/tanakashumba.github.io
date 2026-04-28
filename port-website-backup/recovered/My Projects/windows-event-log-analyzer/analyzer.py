import json

logs = json.load(open("sample_event_logs.json"))

print("Windows Event Log Analyzer Demo\n")
for log in logs:
    print(f"{log['timestamp']} - Event ID: {log['event_id']} - User: {log['user']} - Action: {log['action']}")
