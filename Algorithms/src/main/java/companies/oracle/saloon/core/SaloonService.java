package companies.oracle.saloon.core;

public class SaloonService {

    public static void main(String[] args) {
        /**
         * 1) Intialize the Array
         * 2) Fill in the Array
         * 3) ServeCustomer for the given slot
         *      i) Validation
         *          a) getSlotsFilled - count
         *          b) getGenderBeingServiced - MALE/FEMALE
         *          c) getGenderInQueue - MALE/FEMALE
         *          d) checkIfBothGenderMatches
         *
         *       ii) genderImplementation (3 can run - getSlotsFilled)
         *          a) getServiceList
         *          b)  > chooseService - multiple (loop - break condition)
         *                  or chooseService(listServices)
         *              > submit against the seated slot
         *
         *       iii) getServiceTime for the selected slot
         *          a) getServiceTimeForSlot() - Number in min
         *          a) getRemainingServiceTimeForSlot() - Number in min
         *
         *  4) Batch Check for the given slot
         *      i) customerServiceDone?
         *          a) getServiceTimeForSlot
         *          b) getRemainingServiceTimeForSlot -
         *              0   - True --> ServeCustomerNextInQueue
         *              >0  - FALSE --> Wait for some more time for this given slot
         *
         *
         *   5) genericSlotServingAndCheck and Update Status
         *      i) getNoOfSlots
         *      ii) getNoOfSlotsFilled
         *          ServeCustomer for the given slot
         *          or
         *
         *      ii) Loop
         *          Batch Check for the given slot
         *
         *
         *
         *    List - allCustomersInGeneralQueue
         *    List - priorityWaitList
         *    List - specialCaseGenderWaitList
         *              Model
         *                  GenderName
         *                  waitStartTime
         *                  isMaxWaitTimeReached
         *                      currentTime >= waitStartTime + 30 mins
         *                      return True
         *
         *
         *    M M M F M F F M M
         *
         *    A) //3 - M - 15mins
         *    S) //F
         *    P) //F M M F F
         *
         *    priorityWaitList
         *    Validation
         *      if(priorityWaitList.size > 0)
         *      Loop
         *          getGenderNameFromList -
         *          getGenderBeingServiced -
         *          if(Name.equals(BeingServiced)){
         *              ServeCustomerForTheGivenSlot();
         *              priorityWaitList.remove
         *          }else{
         *              wait till (getSlotsFilled == 0)
         *              ServeCustomerForTheGivenSlot();
         *          }
         *
         */
    }



    /**
     * Scable Array Initiazation
     * @return ArraySize
     */
    private Integer getMaxCustomersSizeForDay(){
        //Total Working Hours per Shift (1hr - 60mins) * Slots (3)
        //Min Service Time
        return 20;
    }
}
