class Graph:

    def __init__(self, n: int, edges: List[List[int]]):

        self.adj_list = [[] for _ in range(n)] # we have to make adjacency list right

        for start,end,cost in edges:
            self.adj_list[start].append((end,cost))  # filling our adj_list


    def addEdge(self, edge: List[int]) -> None:

        start,end,cost = edge #extract values in additional edge

        self.adj_list[start].append((end,cost)) # add those values to adj_list

    def shortestPath(self, node1: int, node2: int) -> int:
        
        #lets start dijikstra algorithm

        # see in dijikstra, we need to always pick the smallest vertix with minimum edgeweight(cost), so we have to use priority queue for that (to store all vertix values i.e, end & cost)

        pq = [(0, node1)] # initially we are sending the source (if i send list of tuples to priority queue, then priority queue will consider first index of tuple as priority)

        # and also we need to maintain a list to store all the cost values from the given single source

        cost_nodes = [float('inf')] * len(self.adj_list)

        cost_nodes[node1] = 0  #as the distance(cost) from source to source is 0

        while pq: 

            curr_cost , curr_node = heapq.heappop(pq) 

            # now, we have to check and make relaxations

            # if our updating cost_node (distance from source) is less than curr_cost, then we no need to perform anything, so we can skip that node.
            if cost_nodes[curr_node] < curr_cost : continue

            # if we reached our search to destination node, then stop and return the distance
            if curr_node == node2 : return cost_nodes[curr_node]

            #push the children
            for child , cost in self.adj_list[curr_node] :
                #now do relaxation
                new_cost = curr_cost + cost

                if new_cost < cost_nodes[child] : 
                    cost_nodes[child] = new_cost
                    heapq.heappush(pq, (new_cost , child))

        return -1
        


# Your Graph object will be instantiated and called as such:
# obj = Graph(n, edges)
# obj.addEdge(edge)
# param_2 = obj.shortestPath(node1,node2)