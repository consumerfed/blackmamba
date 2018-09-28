/**
 * DateSplit.java
 * Developed by steffi Thomas
 * Jan 16, 2018
 */
package com.belazy.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author belazy
 *
 */
public class DateSplit {

	/**
	 * TODO Jan 16, 2018
	 * 
	 * @param args
	 *            void
	 *
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Conditions> cancelConditions = new ArrayList<Conditions>();
		cancelConditions.add(new Conditions(1, 8, 100));
		cancelConditions.add(new Conditions(1, 8, 120));
		cancelConditions.add(new Conditions(9, 12, 110));
		cancelConditions.add(new Conditions(13, 20, 120));
		cancelConditions.add(new Conditions(21, 30, 130));
		cancelConditions.add(new Conditions(9, 18, 130));
		cancelConditions.add(new Conditions(19, 30, 140));
		cancelConditions.add(new Conditions(7, 18, 130));

		Map<Long, Double> treeMap = new TreeMap<Long, Double>();
		for(Conditions c :cancelConditions){
			
			if(treeMap.containsKey(c.getEndDate())){
				treeMap.put(c.getEndDate(), c.getAmount()+treeMap.get(c.getEndDate()));
			}else{
				treeMap.put(c.getEndDate(), c.getAmount());
			}
			
		}

		System.out.println(" cancelCondition before : " + cancelConditions.size());

		DateSplit d = new DateSplit();
		d.splitDate(cancelConditions, treeMap);

	}

	/**
	 * TODO Jan 16, 2018
	 * 
	 * @param cancelConditions
	 *            void
	 * @param treeMap2
	 *
	 */
	private void splitDate(List<Conditions> cancelConditions, Map<Long, Double> treeMap) {

		for (long endDate : treeMap.keySet()) {
			for (Conditions cond2 : cancelConditions) {
				if (endDate > cond2.getStartDate() && endDate < cond2.getEndDate()) {
					if (treeMap.containsKey(endDate)) {
						double mapAmt = treeMap.get(endDate);
						treeMap.put(endDate, cond2.getAmount() + mapAmt);
					} else {
						treeMap.put(endDate, cond2.getAmount());
					}
				}
			}
		}

		System.out.println(" map : " + treeMap);

		long startDate = 0;
		long nextDate = 0;
		for (Map.Entry<Long, Double> entry : treeMap.entrySet()) {
			Long key = entry.getKey();
			Double value = entry.getValue();
			startDate = nextDate + 1;
			nextDate = key;
			System.out.println("startDate : " + startDate + " endDate : " + nextDate + " amount -->" + value);

		}

	}

}
