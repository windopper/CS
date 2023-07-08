#include <bits/stdc++.h>

using namespace std;
vector<vector<int>> g(101);

int main() {

}

// 얻는 보상
int solve(int cur, int depth, int limit) {
    if(limit < depth) {
        return 0;
    }

    int ans = limit >= 2 ? 10 : 5;
    for(int next : g[cur]) {
        ans += solve(next, depth + 1, limit);
    }
    return ans;
}

int solution(vector<vector<int>> arr, int person, int limit) {
    for(vector<int> vec : arr) {
        int a = vec[0];
        int b = vec[1];
        g[a].push_back(b);
        g[b].push_back(a);
    }

    int ans = 0;
    for(int next : g[person]) {
        ans += solve(next, 1, limit);
    }

    return ans;
}