/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 * (subclass) Ans class extends Question and implements comparable interface
 *
 * @author Shuk Ha Kwan
 */
public class Ans extends Question implements Comparable<Ans> {

    /**
     * String variable for input Answer
     */
    public String ansString;

    /**
     * int variable for return ans situation
     */
    public int checkAns;

    public Ans() {
        this.ansString = "";
    }

    /**
     * constructor of ans class
     *
     * @param as get an String ans from main
     */
    public Ans(String as) {
        this.ansString = as;
    }

    /**
     *
     * @param as set ans for compare
     */
    public void setAS(String as) {
        this.ansString = as;
    }

    /**
     *
     * @return ans to compare
     */
    public String getAS() {
        return ansString;
    }

    /**
     *
     * @return Question 3 ans for compare
     */
    public String setQA3() {
        return Integer.toString(ranNum1 * ranNum2 - ranNum1);
    }

    /**
     *
     * @return question 5 ans for compare
     */
    public String setQA5() {
        return "1";
    }

    /**
     * a interface compare function
     *
     * @param o - ans come from main
     * @return a value to detect ans correct or wrong (1 = correct , -1 = wrong)
     */
    @Override
    public int compareTo(Ans o) {
        switch (qNum) {
            case 1:
                if (o.getAS().equals(Integer.toString((int) rect.getArea()))) {
                    checkAns = 1;
                } else {
                    checkAns = -1;
                }
                break;
            case 2:
                if (o.getAS().equals(Integer.toString((int) rect.getPerimeter()))) {
                    checkAns = 1;
                } else {
                    checkAns = -1;
                }
                break;
            case 3:
                if (o.getAS().equals(setQA3())) {
                    checkAns = 1;
                } else {
                    checkAns = -1;
                }
                break;
            case 4:
                circle.setRadius(ranNum1);
                if (o.getAS().equals(Integer.toString((int) circle.getArea()))) {
                    checkAns = 1;
                } else {
                    checkAns = -1;
                }
                break;
            case 5:
                if (o.getAS().equals(setQA5())) {
                    checkAns = 1;
                } else {
                    checkAns = -1;
                }
                break;
            default:
                break;
        }
        return checkAns;
    }
}
