package me.samarthya.EventsServices.ldap.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;

@Configuration
@EnableLdapRepositories(basePackages = "me.samarthya.EventsServices.ldap")
public class ApacheDSConfiguration {
//
//    @Bean
//    ContextSource contextSource() {
//        LdapContextSource ldapContextSource = new LdapContextSource();
//        ldapContextSource.setUserDn("uid=admin,ou=system");
//        ldapContextSource.setUrl("ldap://localhost:10389");
//        ldapContextSource.setPassword("secret");
//        ldapContextSource.setBase("dc=example,dc=com");
//
//        return ldapContextSource;
//    }

    @Bean
    LdapTemplate ldapTemplate(ContextSource contextSource) {
        return new LdapTemplate(contextSource);
    }
}


