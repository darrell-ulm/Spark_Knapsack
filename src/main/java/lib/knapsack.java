package lib.knapsack;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.DataFrame;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

/* Scala code for reference:

  def knapsackApprox(knapsackDF: DataFrame, W: Double): DataFrame = {

    // Add ratio of values / weights column.
    val ratioDF = knapsackDF.withColumn("ratio", knapsackDF("values") / knapsackDF("weights"))
    val newRatioDF = (ratioDF
      .filter(ratioDF("weights") <= W)
      .sort(ratioDF("ratio").desc)
      )

    // An sql method to calculate the partial sums of the ratios.
    newRatioDF.createOrReplaceTempView("tempTable")

    val partialSumWeightsDF = spark.sql("SELECT item, weights, values, ratio, sum(weights) OVER (ORDER BY ratio desc) as partSumWeights FROM tempTable")

    // Get the max number of items, less than or equal to W in Spark.
    val partialSumWeightsFilteredDF = (
      partialSumWeightsDF
        // partialSumWeightsDF.sort(partialSumWeightsDF("ratio").desc)
        .filter(partialSumWeightsDF("partSumWeights") <= W)
      )

    // Return the solution elements with total values, weights and count.
    partialSumWeightsDF
  }
 */

public class knapsack {
    public static DataFrame knapsackApprox(DataFrame knapsackDF, double W) {

        SparkConf conf = new SparkConf().setAppName("Knapsack Approx").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

    }


}
