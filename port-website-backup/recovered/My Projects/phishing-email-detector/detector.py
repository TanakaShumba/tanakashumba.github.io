import re

# Sample emails
emails = [
    {"from": "bank@secure.com", "subject": "Update your password", "body": "Click here to reset your password"},
    {"from": "friend@example.com", "subject": "Hello!", "body": "Hey, long time no see"},
    {"from": "noreply@paypal.com", "subject": "Verify account", "body": "Please click to verify your account"},
]

# Simple phishing patterns
phishing_keywords = ["password", "verify", "click here", "update", "bank", "account"]

def detect_phishing(email):
    text = f"{email['subject']} {email['body']}".lower()
    for kw in phishing_keywords:
        if kw in text:
            return True
    return False

for i, email in enumerate(emails, 1):
    if detect_phishing(email):
        print(f"[ALERT] Email {i} might be phishing: {email}")
    else:
        print(f"[SAFE] Email {i} seems safe: {email}")
