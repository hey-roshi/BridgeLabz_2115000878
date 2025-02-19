import java.util.*;

class Policy implements Comparable<Policy> {
    String policyNumber;
    String policyholderName;
    Date expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "Number='" + policyNumber + '\'' +
                ", Holder='" + policyholderName + '\'' +
                ", Expiry=" + expiryDate +
                ", Type='" + coverageType + '\'' +
                ", Premium=" + premiumAmount +
                '}';
    }
}

public class InsurancePolicyMagt{
    private Map<String, Policy> policyHashMap = new HashMap<>();
    private Map<String, Policy> policyLinkedHashMap = new LinkedHashMap<>();
    private TreeMap<Date, Policy> policyTreeMap = new TreeMap<>();

    // Add policy to all data structures
    public void addPolicy(Policy policy) {
        policyHashMap.put(policy.policyNumber, policy);
        policyLinkedHashMap.put(policy.policyNumber, policy);
        policyTreeMap.put(policy.expiryDate, policy);
    }

    // Retrieve a policy by policy number
    public Policy getPolicyByNumber(String policyNumber) {
        return policyHashMap.get(policyNumber);
    }

    // List all policies expiring within the next 30 days
    public List<Policy> getExpiringPolicies() {
        List<Policy> expiringPolicies = new ArrayList<>();
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Date threshold = cal.getTime();

        for (Map.Entry<Date, Policy> entry : policyTreeMap.entrySet()) {
            if (entry.getKey().before(threshold)) {
                expiringPolicies.add(entry.getValue());
            }
        }
        return expiringPolicies;
    }

    // List all policies for a specific policyholder
    public List<Policy> getPoliciesByHolder(String policyholderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : policyHashMap.values()) {
            if (policy.policyholderName.equalsIgnoreCase(policyholderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        Date today = new Date();
        policyTreeMap.entrySet().removeIf(entry -> entry.getKey().before(today));
    }

    public static void main(String[] args) {
        InsurancePolicyMagt system = new InsurancePolicyMagt();

        // Sample policies
        Calendar cal = Calendar.getInstance();
        
        cal.set(2025, Calendar.MARCH, 10);
        Policy p1 = new Policy("P1001", "Alice", cal.getTime(), "Health", 1200.50);

        cal.set(2024, Calendar.MARCH, 1);
        Policy p2 = new Policy("P1002", "Bob", cal.getTime(), "Auto", 900.75);

        cal.set(2024, Calendar.FEBRUARY, 20);
        Policy p3 = new Policy("P1003", "Charlie", cal.getTime(), "Home", 1500.30);

        system.addPolicy(p1);
        system.addPolicy(p2);
        system.addPolicy(p3);

        // Fetch a specific policy
        System.out.println("Policy Details (P1002): " + system.getPolicyByNumber("P1002"));

        // List policies expiring in 30 days
        System.out.println("\nPolicies Expiring Soon:");
        for (Policy p : system.getExpiringPolicies()) {
            System.out.println(p);
        }

        // Get policies by holder
        System.out.println("\nPolicies of Bob:");
        for (Policy p : system.getPoliciesByHolder("Bob")) {
            System.out.println(p);
        }

        // Remove expired policies
        system.removeExpiredPolicies();
        System.out.println("\nPolicies after removing expired ones:");
        for (Policy p : system.policyTreeMap.values()) {
            System.out.println(p);
        }
    }
}
