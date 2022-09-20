/*
 * Copyright (c) 2022 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.app.test.fakes

import arrow.core.Option
import im.vector.app.SpaceStateHandler
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flowOf
import org.matrix.android.sdk.api.session.room.model.RoomSummary

class FakeSpaceStateHandler : SpaceStateHandler by mockk(relaxed = true) {

    fun getSelectedSpaceFlowReturns(space: RoomSummary) {
        every { getSelectedSpaceFlow() } returns flowOf(Option(space))
    }

    fun verifySetCurrentSpace(spaceId: String) {
        verify { setCurrentSpace(spaceId) }
    }
}
