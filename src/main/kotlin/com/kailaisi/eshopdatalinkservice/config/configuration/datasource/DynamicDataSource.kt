import com.kailaisi.eshopdatalinkservice.config.configuration.datasource.DynamicDataSourceHolder
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource

/**
 *描述：spring提供了AbstractRoutingDataSource，提供了动态选择数据源的功能，替换原有的单一数据源后，即可实现读写分离。
 * AbstractRoutingDataSource中持有targetDataSources对象，里面保存了所有能够切换的数据源信息
 *<p/>作者：wu
 *<br/>创建时间：2019/12/21 22:38
 */
class DynamicDataSource : AbstractRoutingDataSource() {
    //返回对应的数据源名称，就可以根据从map中取到对应的数据源
    override fun determineCurrentLookupKey(): Any? {
        return DynamicDataSourceHolder.getDbType()
    }
}