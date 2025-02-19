import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteCountMap = new HashMap<>(); // Stores votes per candidate
    private Map<String, Integer> voteOrderMap = new LinkedHashMap<>(); // Maintains vote order

    // Cast a vote for a candidate
    public void castVote(String candidate) {
        voteCountMap.put(candidate, voteCountMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteOrderMap.getOrDefault(candidate, 0) + 1);
    }

    // Get vote count for a specific candidate
    public int getVoteCount(String candidate) {
        return voteCountMap.getOrDefault(candidate, 0);
    }

    // Get results sorted by candidate name
    public Map<String, Integer> getResultsSortedByName() {
        return new TreeMap<>(voteCountMap);
    }

    // Get results sorted by vote count (descending order)
    public Map<String, Integer> getResultsSortedByVotes() {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(voteCountMap.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue())); // Sort by votes in descending order

        Map<String, Integer> sortedByVotes = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedByVotes.put(entry.getKey(), entry.getValue());
        }
        return sortedByVotes;
    }

    // Display results in vote order
    public void displayVoteOrder() {
        System.out.println("\nVote Order:");
        for (Map.Entry<String, Integer> entry : voteOrderMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Simulate voting
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");

        // Display vote counts
        System.out.println("Vote Count for Alice: " + votingSystem.getVoteCount("Alice"));

        // Display results sorted by candidate name
        System.out.println("\nResults Sorted by Name:");
        for (Map.Entry<String, Integer> entry : votingSystem.getResultsSortedByName().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Display results sorted by votes
        System.out.println("\nResults Sorted by Vote Count:");
        for (Map.Entry<String, Integer> entry : votingSystem.getResultsSortedByVotes().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Display vote order
        votingSystem.displayVoteOrder();
    }
}
