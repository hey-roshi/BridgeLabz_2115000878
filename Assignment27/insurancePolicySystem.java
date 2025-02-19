import java.util.*;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate); // Sort by expiry date
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InsurancePolicy that = (InsurancePolicy) obj;
        return Objects.equals(policyNumber, that.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "Number='" + policyNumber + '\'' +
                ", Holder='" + policyholderName + '\'' +
                ", Expiry=" + expiryDate +
                ", Coverage='" + coverageType + '\'' +
                ", Premium=" + premiumAmount +
                '}';
    }
}

class InsurancePolicyManager {
    private Set<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("\n--- All Policies ---");
        for (InsurancePolicy policy : hashSetPolicies) {
            System.out.println(policy);
        }
    }

    public void displayExpiringSoon() {
        System.out.println("\n--- Policies Expiring Soon (Next 30 Days) ---");
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Date futureDate = cal.getTime();

        for (InsurancePolicy policy : treeSetPolicies) {
            if (policy.getExpiryDate().before(futureDate)) {
                System.out.println(policy);
            }
        }
    }

    public void displayByCoverageType(String type) {
        System.out.println("\n--- Policies with Coverage Type: " + type + " ---");
        for (InsurancePolicy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(policy);
            }
        }
    }

    public void findDuplicates() {
        System.out.println("\n--- Duplicate Policies ---");
        Map<String, Integer> countMap = new HashMap<>();
        for (InsurancePolicy policy : hashSetPolicies) {
            countMap.put(policy.getPolicyNumber(), countMap.getOrDefault(policy.getPolicyNumber(), 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Duplicate Policy Number: " + entry.getKey());
            }
        }
    }

    public void comparePerformance() {
        System.out.println("\n--- Performance Comparison ---");
        measurePerformance(new HashSet<>(), "HashSet");
        measurePerformance(new LinkedHashSet<>(), "LinkedHashSet");
        measurePerformance(new TreeSet<>(), "TreeSet");
    }

    private void measurePerformance(Set<InsurancePolicy> set, String setType) {
        long startTime, endTime;

        // Insertion time
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            set.add(new InsurancePolicy("P" + i, "Holder" + i, new Date(), "Health", 100 + i));
        }
        endTime = System.nanoTime();
        System.out.println(setType + " Insert Time: " + (endTime - startTime) / 1e6 + " ms");

        // Search time
        startTime = System.nanoTime();
        set.contains(new InsurancePolicy("P5000", "Test", new Date(), "Auto", 5000));
        endTime = System.nanoTime();
        System.out.println(setType + " Search Time: " + (endTime - startTime) / 1e6 + " ms");

        // Removal time
        startTime = System.nanoTime();
        set.remove(new InsurancePolicy("P5000", "Test", new Date(), "Auto", 5000));
        endTime = System.nanoTime();
        System.out.println(setType + " Remove Time: " + (endTime - startTime) / 1e6 + " ms");
    }
}

public class insurancePolicySystem{
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();
        Calendar cal = Calendar.getInstance();

        cal.set(2025, Calendar.JUNE, 10);
        InsurancePolicy policy1 = new InsurancePolicy("P123", "Alice", cal.getTime(), "Health", 1200.50);

        cal.set(2025, Calendar.MARCH, 5);
        InsurancePolicy policy2 = new InsurancePolicy("P124", "Bob", cal.getTime(), "Auto", 900.75);

        cal.set(2024, Calendar.FEBRUARY, 28);
        InsurancePolicy policy3 = new InsurancePolicy("P125", "Charlie", cal.getTime(), "Home", 1500.00);

        manager.addPolicy(policy1);
        manager.addPolicy(policy2);
        manager.addPolicy(policy3);

        manager.displayAllPolicies();
        manager.displayExpiringSoon();
        manager.displayByCoverageType("Health");
        manager.findDuplicates();
        manager.comparePerformance();
    }
}

