package guimodule;

public class Search {

	public static void main(String[] args) {

	}

	public String searchLinear(String city, Airport[] airports) {
		for (int i = 0; i < airports.length; i++) {
			if (airports[i].getCity().equals(city)) {
				return airports[i].getCode3();
			}
		}
		return null;
	}

	public String searchBinary(String city, Airport[] airports) {
		int low = 0, high = airports.length;
		int mid;
		Airport current;

		while (low <= high) {
			mid = low + (high - low) / 2;
			current = airports[mid];
			int compare = city.compareTo(current.getCity());
			if (compare == 0) {
				return current.getCode3();
			}
			// If string needs to be searched in lower half
			else if (compare < 0)
				high = mid - 1;
			else
				low = mid + 1;
		}

		return null;
	}
}
