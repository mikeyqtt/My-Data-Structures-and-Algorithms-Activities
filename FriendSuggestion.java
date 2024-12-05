import java.util.*;

public class FriendSuggestion{

    // Graph represented as an adjacency list
    private Map<String, List<String>> friendGraph;

    public FriendSuggestion() {
        friendGraph = new HashMap<>();
    }

    // Add a user (node) to the graph
    public void addUser(String user) {
        friendGraph.putIfAbsent(user, new ArrayList<>());
    }

    // Add a friendship (undirected edge)
    public void addFriendship(String user1, String user2) {
        friendGraph.putIfAbsent(user1, new ArrayList<>());
        friendGraph.putIfAbsent(user2, new ArrayList<>());
        friendGraph.get(user1).add(user2);
        friendGraph.get(user2).add(user1); // Undirected friendship
    }

    // Suggest friends for a given user (friends of friends)
    public List<String> suggestFriends(String user) {
        List<String> suggestions = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Set<String> userFriends = new HashSet<>();

        // Check if the user exists
        if (!friendGraph.containsKey(user)) {
            return suggestions;
        }

        // Collect the user's direct friends
        userFriends.addAll(friendGraph.get(user));

        // Traverse through friends of friends
        for (String friend : userFriends) {
            if (!visited.contains(friend)) {
                visited.add(friend);
                for (String friendOfFriend : friendGraph.get(friend)) {
                    if (!friendOfFriend.equals(user) && !userFriends.contains(friendOfFriend)) {
                        suggestions.add(friendOfFriend);
                    }
                }
            }
        }

        return suggestions;
    }

    // Display the friend graph
    public void displayGraph() {
        System.out.println("Friend Graph:");
        for (String user : friendGraph.keySet()) {
            System.out.println(user + " -> " + friendGraph.get(user));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FriendSuggestion system = new FriendSuggestion();

        // Add users
        System.out.print("Enter number of users: ");
        int numUsers = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < numUsers; i++) {
            System.out.print("Enter username: ");
            String user = scanner.nextLine();
            system.addUser(user);
        }

        // Add friendships
        System.out.print("Enter number of friendships: ");
        int numFriendships = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < numFriendships; i++) {
            System.out.println("Enter two users to connect (user1 user2):");
            String user1 = scanner.next();
            String user2 = scanner.next();
            scanner.nextLine(); // Consume newline
            system.addFriendship(user1, user2);
        }

        // Suggest friends for a user
        System.out.print("Enter a user to suggest friends: ");
        String user = scanner.nextLine();
        List<String> suggestions = system.suggestFriends(user);

        System.out.println("Friend suggestions for " + user + ":");
        if (suggestions.isEmpty()) {
            System.out.println("No suggestions available.");
        } else {
            for (String suggestion : suggestions) {
                System.out.println(suggestion);
            }
        }

        // Display the graph
        system.displayGraph();

        scanner.close();
    }
}