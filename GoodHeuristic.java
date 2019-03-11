//
// GoodHeuristic
//
// This class extends the Heuristic class, providing a reasonable
// implementation of the heuristic function method. The provided "good"
// heuristic function is admissible.
//
// Julian Cook -- 10/10/18
//


// IMPORT ANY PACKAGES THAT YOU NEED.
// import java.util.*;

import static java.lang.Math.sqrt;
public class GoodHeuristic extends Heuristic {

        // YOU CAN ADD ANYTHING YOU LIKE TO THIS CLASS ... WHATEVER WOULD
        // ASSIST IN THE CALCULATION OF YOUR GOOD HEURISTIC VALUE.

	// heuristicValue -- Return the appropriate heuristic values for the
	// given search tree node. Note that the given Node should not be
	// modified within the body of this function.
	public Location dest;

	public GoodHeuristic(Location dest)
	{
		this.dest = dest;
	}

	public double heuristicValue(Node thisNode) {
		double hVal = 0.0;
		double shortestRoad = 3.1; //shortest road value
		double lat = dest.latitude - thisNode.loc.latitude;
		double lon = dest.longitude - thisNode.loc.longitude;
		hVal = (sqrt((lat*lat) + (lon*lon))) / shortestRoad;
		return (hVal);
	}

}
