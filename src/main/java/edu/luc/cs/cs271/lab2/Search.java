package edu.luc.cs.cs271.lab2;

import java.util.List;
import java.util.Optional;

public class Search {

  /** Looks for the position of the named team in an array. */
  public static Optional<Integer> findTeamPosition(final Team[] arr, final String key) {
    // Gets the array size
    final int size = arr.length;
    // Runs through a for loop to check
    for (int i = 0; i < size; i++) {
      // Gets the current item at index and compare name to key
      if (arr[i].getName().equals(key)) {
        // Return the index of where the item with key is located
        return Optional.of(i);
      }
    }
    // If it does not exist in the array then return an index of -1
    return Optional.empty();
  }

  /** Looks for the position of the named team in a list. */
  public static Optional<Integer> findTeamPosition(final List<Team> list, final String key) {
    //create list size
    final int size = list.size();
    int i = 0;
    for (Team pos: list) {
      pos = list.get(i);
      //gets the recent item at the index and compares it to the given key
      if (pos.getName().equals(key)) {
        //returns the index in which the key is
        return Optional.of(i);
      }
      i++;
    }
    return Optional.empty();
  }
  
  /** 
   * Looks for the position of the poorest team that has at least 
   * the specified funding level.
   * @pre arr is sorted
   * @post arr[result].funding >= minFunding && for all 0 <= i < result : arr[i].funding < minFunding
   */
  //linear search
  public static Optional<Integer> findTeamMinFunding(final Team[] arr, final int minFunding) {
    final int size = arr.length;
    for (int i = 0; i < size; i++){
      if(arr[i].getFunding() >= minFunding)
      {
        return Optional.of(i);
      }
    }
    return Optional.empty();
  }
  
  /** 
   * Looks for the position of the poorest team that has at least 
   * the specified funding level. 
   * Uses binary search: Initially consider the entire index range, 
   * then repeatedly eliminate the wrong half of the array until 
   * zero or one items are left.
   * @pre arr is sorted
   * @post arr[result].funding >= minFunding && for all 0 <= i < result : arr[i].funding < minFunding
   */
  public static Optional<Integer> findTeamMinFundingFast(final Team[] arr, final int minFunding) {
    final int size = arr.length;
    if (size == 0)
    {
      return Optional.empty();
    }
    int low = 0;
    int high = size - 1;
    while (low != high) {
      int mid;
      mid = ((low + high) / 2);
      if (arr[mid].getFunding() >= minFunding) {
        for (int i = low; i <= mid; i++)
        {
          if (arr[i].getFunding() >= minFunding) {
            low = i;
            high = low;
            break;
          }
        }
      } else if (arr[mid].getFunding() < minFunding) {
        low = mid + 1;
      }
    }
    if (low <= high && arr[low].getFunding() >= minFunding) {
      return Optional.of(low);
    } else {
      return Optional.empty();
    }
  }
}
