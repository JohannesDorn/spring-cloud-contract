package io.codearte.accurest.stubrunner

import groovy.transform.CompileStatic
import groovy.transform.PackageScope
import groovy.transform.ToString

/**
 * Technical options related to running StubRunner
 *
 * Use {@class StubRunnerOptionsBuilder} to build this object.
 *
 * @see StubRunnerOptionsBuilder
 */
@ToString(includeNames = true)
@CompileStatic
class StubRunnerOptions {

	/**
	 * min port value of the WireMock instance for the given collaborator
	 */
	final Integer minPortValue

	/**
	 * max port value of the WireMock instance for the given collaborator
	 */
	final Integer maxPortValue

	/**
	 * root URL from where the JAR with stub mappings will be downloaded
	 */
	final String stubRepositoryRoot

	/**
	 * avoids local repository in dependency resolution
	 */
	final boolean workOffline

	/**
	 * stub definition classifier
	 */
	final String stubsClassifier

	final Collection<StubConfiguration> dependencies

	/**
	 * colon separated list of ids to the desired port
	 */
	final Map<StubConfiguration, Integer> stubIdsToPortMapping

	@PackageScope
	StubRunnerOptions(Integer minPortValue, Integer maxPortValue, String stubRepositoryRoot,
	                  boolean workOffline, String stubsClassifier, Collection<StubConfiguration> dependencies, Map<StubConfiguration, Integer> stubIdsToPortMapping) {
		this.minPortValue = minPortValue
		this.maxPortValue = maxPortValue
		this.stubRepositoryRoot = stubRepositoryRoot
		this.workOffline = workOffline
		this.stubsClassifier = stubsClassifier
		this.dependencies = dependencies
		this.stubIdsToPortMapping = stubIdsToPortMapping
	}

	Integer port(StubConfiguration stubConfiguration) {
		if (stubIdsToPortMapping) {
			return stubIdsToPortMapping[stubConfiguration]
		} else {
			return null
		}
	}

}
