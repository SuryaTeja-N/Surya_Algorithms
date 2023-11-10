class Solution:
    def restoreArray(self, adjacentPairs: List[List[int]]) -> List[int]:
        graph = defaultdict(list)
        
        for x, y in adjacentPairs:
            graph[x].append(y)
            graph[y].append(x)
        
        root = None
        for num in graph:
            if len(graph[num]) == 1:
                root = num
                break
        
        def bfs(node):
            ans = []
            queue = deque([node])
            visited = set([node])
            while queue:
                cur = queue.popleft()
                ans.append(cur)
                for neighbor in graph[cur]:
                    if neighbor not in visited:
                        queue.append(neighbor)
                        visited.add(neighbor)
            return ans

        return bfs(root)
