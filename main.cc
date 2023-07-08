#include <bits/stdc++.h>

using namespace std;

int solution(string s, int N) {

    string result = "0";
    // 1000
    for(int i=0; i<s.size()-N; i++) {
        vector<bool> checked(N+1, false);
        bool full = true;
        // 10
        for(int j=0; j<N; j++) {
            int cur = s[i + j] - '0';
            if(cur > N || checked[cur]) {
                full = false;
                break;
            }
            checked[cur] = true;
        }

        string temp = s.substr(i, N);
        if(full && result < temp) {
            result = temp;
        }
    }

    if(result == "0") return -1;
    return stoi(result);
}

int main() {
    cout << solution("1451232125", 2) << endl;
    cout << solution("313253123", 3) << endl;
    cout << solution("12412415", 4) << endl;
    cout << solution("100210000", 2) << endl;
}