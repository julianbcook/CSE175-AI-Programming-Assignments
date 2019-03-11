import java.util.HashSet;

public class GreedySearch
{
	public int expansionCount = 0;
	StreetMap map;
	Location start;
	Location end;
	int limit;

	public GreedySearch(StreetMap map, String initial, String dest, int limit)
	{
		this.map = map;
		start = map.findLocation(initial);
		end = map.findLocation(dest);
		this.limit = limit;
	}

	public Node search(boolean stateChecking)
	{


		HashSet<Location> explored = new HashSet<Location>();
		HashSet<Node> junk = new HashSet<Node>();

		SortedFrontier front = new SortedFrontier(SortBy.h);
		Node node = new Node(start);
		front.addSorted(node);

		while(expansionCount < limit)
		{
			if (front.isEmpty())
				return null;
			Node temp = front.removeTop();
			if (temp.isDestination(end.name))
				return temp;
			else
			{
				GoodHeuristic h = new GoodHeuristic(end);
				temp.expand(h);

				if (stateChecking == true)
				{
					explored.add(temp.loc);
					for (Node i : temp.children)
					{
						if(explored.contains(i.loc) || front.contains(i))
							junk.add(i);
					}
					temp.children.remove(junk);
					front.addSorted(temp.children);
				}
				else
				{
					front.addSorted(temp.children);
				}
        expansionCount++;
			}
			node = temp;
		}
		return null;
	}
}
