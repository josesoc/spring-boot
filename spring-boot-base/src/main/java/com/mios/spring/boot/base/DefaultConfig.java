package com.mios.spring.boot.base;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Default configuration.
 * This separation from Application Config enable us to load application context in Junit Tests.
 * 
 * SpringBootApplication instead of:
 * 	Configuration
 *	ComponentScan
 *	EnableAutoConfiguration
 * 
 * @author jmroldanv
 */
@SpringBootApplication
public class DefaultConfig {

}
