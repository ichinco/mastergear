grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

// uncomment (and adjust settings) to fork the JVM to isolate classpaths
//grails.project.fork = [
//   run: [maxMemory:1024, minMemory:64, debug:false, maxPerm:256]
//]

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

//    grails.plugin.location.elasticsearch="C:/Users/denise/Code/elasticsearch-grails-plugin"

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        mavenRepo "https://oss.sonatype.org/content/groups/public/"

        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()
        mavenCentral()

        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
        runtime 'postgresql:postgresql:9.0-801.jdbc4'
        // runtime 'mysql:mysql-connector-java:5.1.22'
        compile "io.searchbox:jest:0.0.3"
        compile 'org.codehaus.gpars:gpars:1.0.0'

    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        compile ":resources:1.2.RC2"

        // Uncomment these (or add new ones) to enable additional resources capabilities
        compile ":cache-headers:1.1.5"
        runtime ":zipped-resources:1.0"
        runtime ":cached-resources:1.0"
//        runtime ":yui-minify-resources:0.1.5"

        build ":tomcat:$grailsVersion"

        runtime ":database-migration:1.3.2"

        compile ':cache:1.0.1'

        compile ':spring-security-core:1.2.7.3'
        compile ':mail:1.0'
        compile ':jquery:1.8.3'
        compile ':jquery-ui:1.8.7'
        compile ':famfamfam:1.0'
//        compile ':spring-security-ui:0.2'
        compile ":backbonejs:0.9.10.3"
        compile ":csv:0.3.1"
        compile ":rest:0.7"

        runtime ':twitter-bootstrap:3.0.3'
        compile ":cxf-client:1.6.0"
    }
}
