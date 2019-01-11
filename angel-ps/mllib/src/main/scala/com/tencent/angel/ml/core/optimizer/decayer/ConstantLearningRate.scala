package com.tencent.angel.ml.core.optimizer.decayer

import com.tencent.angel.ml.core.conf.{MLConf, SharedConf}

class ConstantLearningRate(eta: Double) extends StepSizeScheduler {
  var current: Int = 0
  val interval: Int = SharedConf.get().getInt(MLConf.ML_OPT_DECAY_INTERVALS, 100)

  override def next(): Double = {
    current += 1
    eta
  }

  override def isIntervalBoundary: Boolean = {
    current % interval == 0
  }
}