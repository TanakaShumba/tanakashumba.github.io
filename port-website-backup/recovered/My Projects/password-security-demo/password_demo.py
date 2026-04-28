#!/usr/bin/env python3
import hashlib, os, getpass
try:
    from zxcvbn import zxcvbn
except Exception:
    zxcvbn = None

def hash_password(pw, salt=None):
    if salt is None:
        salt = os.urandom(16)
    hashed = hashlib.pbkdf2_hmac('sha256', pw.encode(), salt, 100_000)
    return salt.hex(), hashed.hex()

def main():
    pw = getpass.getpass("Enter a password to test (won't be stored): ")
    if zxcvbn:
        score = zxcvbn(pw)['score']
        print("Password strength score (0-4):", score)
    else:
        print("zxcvbn not installed; install zxcvbn-python for strength scoring.")
    salt, h = hash_password(pw)
    print("Salt:", salt)
    print("Hash:", h)

if __name__=="__main__":
    main()
