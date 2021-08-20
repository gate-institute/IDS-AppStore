/*
 * Copyright 2020 Fraunhofer Institute for Software and Systems Engineering
 * Copyright 2021 Fraunhofer Institute for Applied Information Technology
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.dataspaceconnector.extension.idscp.processor;

import de.fraunhofer.iais.eis.ContractAgreement;
import io.dataspaceconnector.common.routing.ParameterUtils;
import io.dataspaceconnector.extension.idscp.processor.base.Idscp2MappingProcessor;
import io.dataspaceconnector.service.message.handler.dto.Request;
import org.apache.camel.Message;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * Prepares a request message for IDSCPv2 communication with a contract agreement as payload.
 */
@Component("ContractAgreementPreparer")
public class ContractAgreementPreparer extends Idscp2MappingProcessor {

    /**
     * Prepares a {@link Request} with a contract agreement as body for communication over IDSCPv2.
     * @param in the in-message of the exchange.
     */
    @Override
    protected void processInternal(final Message in) {
        final var request = in.getBody(Request.class);
        final var agreement = (ContractAgreement) request.getBody();

        in.setHeader(ParameterUtils.IDSCP_HEADER, request.getHeader());
        in.setBody(agreement.toRdf().getBytes(StandardCharsets.UTF_8));
    }

}
