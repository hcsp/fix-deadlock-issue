package com.github.hcsp.multithread;

import com.github.blindpirate.extensions.CaptureSystemOutput;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    @CaptureSystemOutput
    public void test(CaptureSystemOutput.OutputCapture capture) throws Exception {
        capture.expect(Matchers.matchesRegex("(?s).*start f1\\s+start f2\\s+end f1.*"));
        Main.main(null);
    }
}
