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
package io.dataspaceconnector.common.usagecontrol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllowAccessVerifierTest {
    @Test
    public void verify_null_returnAllowed() {
        /* ARRANGE */
        final var verifier = new AllowAccessVerifier();

        /* ACT */
        final var result = verifier.verify(null);

        /* ASSERT */
        assertEquals(VerificationResult.ALLOWED, result);
    }


    @Test
    public void verify_any_returnAllowed() {
        /* ARRANGE */
        final var verifier = new AllowAccessVerifier();
        final var input = new AccessVerificationInput();

        /* ACT */
        final var result = verifier.verify(input);

        /* ASSERT */
        assertEquals(VerificationResult.ALLOWED, result);
    }
}
