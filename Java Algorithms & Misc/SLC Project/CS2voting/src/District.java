/**
 * @author Zach D. & Robin A.
 */
public class District {
	private String [] candidates;
	private Integer [] candidateVote;
	
	/**
	 * @param newCans
	 */
	public District(String[] newCans) {
		setCandidates(newCans);
		sortCandidates();
	}
	
	/**
	 * 
	 */
	public void displayCandidates () {
		int i = 0;
		for (String j: candidates) {
			System.out.printf("Candidate #%s: %s%n",i+1, j);
			i++;
		}
	}
	
	/**
	 * @return
	 */
	public int candAmount () {
		return candidates.length;
	}
	
	/**
	 * @param newVote
	 */
	public void addVote (int newVote) {
		candidateVote[newVote-1]++;
	}
	
	/**
	 * @param newCans
	 */
	private void setCandidates (String [] newCans) {
		candidates = newCans;
		candidateVote = new Integer[newCans.length];
		for (int i = 0; i < candidates.length; i++) {
			candidateVote[i] = 0;
		}
	}
	
	/**
	 * 
	 */
	private void sortCandidates() {
		String nameTemp = "";
		for (int i = 1; i < candidates.length; i++) {
			for (int j = i; j > 0; j--) {
				if (candidates[j-1].compareToIgnoreCase(candidates[j]) > 0) {
					nameTemp = candidates[j];
					candidates[j] = candidates[j-1];
					candidates[j-1] = nameTemp;
				}
			}	
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String voteTally = "";
		for (int i = 0; i < candidates.length; i++) {
			voteTally = voteTally.concat(String.format("Candidate #%s: %s. Total votes: %s%n", i+1, candidates[i], candidateVote[i]));
		}
		return voteTally;
	}
}
