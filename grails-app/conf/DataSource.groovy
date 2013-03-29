dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:postgresql://ec2-107-20-147-106.compute-1.amazonaws.com:5432/dekdff62cl17q7?user=fasgditgasposh&password=e86svWxfxIvvwof9mDd2drThFR&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory"
            driverClassName = "org.postgresql.Driver"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:postgresql://ec2-107-20-147-106.compute-1.amazonaws.com:5432/dekdff62cl17q7?user=fasgditgasposh&password=e86svWxfxIvvwof9mDd2drThFR&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory"
            driverClassName = "org.postgresql.Driver"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
