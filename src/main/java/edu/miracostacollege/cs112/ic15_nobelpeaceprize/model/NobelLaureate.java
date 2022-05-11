package edu.miracostacollege.cs112.ic15_nobelpeaceprize.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Objects;

public class NobelLaureate implements Serializable{
  private String mName;
  private int mAwardYear;
  private String mMotivation;
  private String mCountry;
  private double mPrizeAmount;

  public String getName() {
    return mName;
  }

  public void setName(String name) {
    mName = name;
  }

  public int getAwardYear() {
    return mAwardYear;
  }

  public void setAwardYear(int awardYear) {
    mAwardYear = awardYear;
  }

  public String getMotivation() {
    return mMotivation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NobelLaureate that = (NobelLaureate) o;
    return mAwardYear == that.mAwardYear && Double.compare(that.mPrizeAmount, mPrizeAmount) == 0 && Objects.equals(mName, that.mName) && Objects.equals(mMotivation, that.mMotivation) && Objects.equals(mCountry, that.mCountry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mName, mAwardYear, mMotivation, mCountry, mPrizeAmount);
  }

  public void setMotivation(String motivation) {
    mMotivation = motivation;
  }

  public String getCountry() {
    return mCountry;
  }

  public void setCountry(String country) {
    mCountry = country;
  }

  public double getPrizeAmount() {
    return mPrizeAmount;
  }

  public void setPrizeAmount(double prizeAmount) {
    mPrizeAmount = prizeAmount;
  }

  public NobelLaureate(String name, int awardYear, String motivation, String birthCountry, double prizeAmount) {
    mName = name;
    mAwardYear = awardYear;
    mMotivation = motivation;
    mCountry = birthCountry;
    mPrizeAmount = prizeAmount;
  }

  @Override
  public String toString() {
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    return "Nobel Laureate [" +
            mAwardYear +
            ", Name=" + mName +
            ", Motivation=" + mMotivation +
            ", Country=" + mCountry +
            ", Prize=" + currency.format(mPrizeAmount) +
            ']';
  }
}
