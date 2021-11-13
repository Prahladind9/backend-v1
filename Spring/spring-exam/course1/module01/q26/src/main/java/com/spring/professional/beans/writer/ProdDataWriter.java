package com.spring.professional.beans.writer;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!dev")
public class ProdDataWriter implements DataWriter{
}
