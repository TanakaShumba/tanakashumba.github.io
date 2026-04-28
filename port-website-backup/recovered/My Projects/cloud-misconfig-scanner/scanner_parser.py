#!/usr/bin/env python3
import json

def load(p): return json.load(open(p))

def check_s3(bucket):
    findings=[]
    if bucket.get('ACL','')=='public-read' or '"Effect":"Allow"' in bucket.get('Policy',''):
        findings.append("Public bucket or permissive policy")
    return findings

if __name__=="__main__":
    data = load("samples/aws_s3_sample.json")
    for b in data.get('buckets',[]):
        issues = check_s3(b)
        print(f"{b['name']}: {issues if issues else 'OK'}")
