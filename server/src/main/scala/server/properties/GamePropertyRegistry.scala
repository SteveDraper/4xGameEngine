package server.properties

import state.property.DoubleProperty.DoubleProperty
import state.property.{BasicSparseVectorProperty, PropertyId, PropertyMapState, PropertyUpdater}
import topology.Cell

object GamePropertyRegistry extends PropertyRegistry[DoubleProperty, BasicSparseVectorProperty[DoubleProperty]] {
  val scalarProperties = Map(
    PropertyId(0) -> PropertyInfo("Height", "Height above sea level",heightUpdater)
  )
  val vectorProperties = Map[PropertyId,PropertyInfo[BasicSparseVectorProperty[Double]]]()

  def scalarUpdaters = scalarProperties.toList.sortBy(_._1.value).map(_._2.updater).toArray

  def vectorUpdaters = vectorProperties.toList.sortBy(_._1.value).map(_._2.updater).toArray

  private def heightUpdater: PropertyUpdater[DoubleProperty] = new PropertyUpdater[DoubleProperty] {
    def update[C <: Cell, R](initialValue: DoubleProperty, id: PropertyId, cellState: (C) => R, parentLens: (R) => PropertyMapState[DoubleProperty], neighbours: Traversable[C]): DoubleProperty = {
      ???
    }
  }
}