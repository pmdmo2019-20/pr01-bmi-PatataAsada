package es.iessaladillo.pedrojoya.pr01.bmi;

/**
 * Allow Bmi calculation and clasification
 */
public class BmiCalculator {

    /**
     * @param weightInKgs    Weight of the person in kgs
     * @param heightInMeters Height of the person in meters
     * @return The body mass index (BMI)
     */
    public float calculateBmi(float weightInKgs, float heightInMeters) {
        if (weightInKgs <= 0) throw new IllegalArgumentException();
        if (heightInMeters <= 0) throw new IllegalArgumentException();
        float bmi = weightInKgs / (heightInMeters * heightInMeters);
        return bmi;
    }


    /**
     * @param bmi Body mass index to get clasification from
     * @return A BmiClasification enum with the clasification of BMI
     */
    public BmiClasification getBmiClasification(float bmi) {
        BmiClasification result = null;
        if (bmi < 18.5f) result = BmiClasification.LOW_WEIGHT;
        if (18.5f <= bmi && bmi < 25f) result = BmiClasification.NORMAL_WEIGHT;
        if (25f <= bmi && bmi < 30f) result = BmiClasification.OVERWWEIGHT;
        if (30f <= bmi && bmi < 35f) result = BmiClasification.OBESITY_GRADE_1;
        if (35f <= bmi && bmi < 40f) result = BmiClasification.OBESITY_GRADE_2;
        if (bmi >= 40f) result = BmiClasification.OBESITY_GRADE_3;
        return result;
    }

    public enum BmiClasification {
        LOW_WEIGHT, NORMAL_WEIGHT, OVERWWEIGHT, OBESITY_GRADE_1, OBESITY_GRADE_2, OBESITY_GRADE_3
    }
}
