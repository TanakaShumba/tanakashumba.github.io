from flask import Flask, request, jsonify
import os
from dotenv import load_dotenv
from time import sleep
load_dotenv()
app = Flask(__name__)
USERNAME = os.getenv("TEST_USERNAME", "admin")
PASSWORD = os.getenv("TEST_PASSWORD", "Pa$$w0rd")
@app.route("/")
def index():
    return jsonify({"service":"Login Brute-Force Simulator (local only)","note":"Local only."})
@app.route("/login", methods=["POST"])
def login():
    data = request.get_json(silent=True) or {}
    username = data.get("username", "")
    password = data.get("password", "")
    if not hasattr(app, "failed"):
        app.failed = {}
    key = username
    attempts = app.failed.get(key, 0)
    if attempts >= 5:
        return jsonify({"success": False, "error": "account_locked", "message": "Too many attempts. Try later."}), 429
    sleep(0.15)
    if username == USERNAME and password == PASSWORD:
        app.failed[key] = 0
        return jsonify({"success": True, "message": "login_success"})
    else:
        app.failed[key] = attempts + 1
        return jsonify({"success": False, "message": "invalid_credentials"}), 401
if __name__ == "__main__":
    app.run(host="127.0.0.1", port=5000, debug=False)
