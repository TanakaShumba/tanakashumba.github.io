#!/usr/bin/env python3
import json

def parse_nmap(path):
    n = json.load(open(path))
    model = {'hosts':[]}
    for h in n.get('hosts',[]):
        host = {'ip':h['ip'], 'services':[p['service'] for p in h.get('ports',[])]}
        model['hosts'].append(host)
    return model

if __name__=="__main__":
    model = parse_nmap("sample_nmap.json")
    json.dump(model, open("threat_model.json",'w'), indent=2)
    print("Threat model written to threat_model.json")
