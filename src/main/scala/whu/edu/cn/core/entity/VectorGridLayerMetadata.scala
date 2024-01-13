package whu.edu.cn.core.entity

import geotrellis.layer.{Bounds, SpatialKey}
import geotrellis.proj4.CRS
import geotrellis.vector.Extent
import scala.beans.BeanProperty
import whu.edu.cn.core.vector.grid.GridConf


case class VectorGridLayerMetadata[K] (_gridConf: GridConf,
                               _extent: Extent = null,
                               _bounds: Bounds[K] = null,
                               _crs: CRS = CRS.fromEpsgCode(4326),
                               _productName: String = ""){
  @BeanProperty
  var gridConf = _gridConf
  @BeanProperty
  var extent = _extent
  @BeanProperty
  var bounds = _bounds
  @BeanProperty
  var crs = _crs
  @BeanProperty
  var productName = _productName

}
