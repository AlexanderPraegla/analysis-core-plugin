package io.jenkins.plugins.analysis.core.steps;

import hudson.util.FormValidation;
import org.junit.jupiter.api.Test;

import static io.jenkins.plugins.analysis.core.testutil.FormValidationAssert.assertThat;

class IssuesRecorderTest {

	@Test
	void shouldBeOkIfEncodingIsEmtpy() {
		// given
		IssuesRecorder.Descriptor descriptor = new IssuesRecorder.Descriptor();

		// when
		FormValidation formValidation = descriptor.doCheckSourceCodeEncoding("");

		// then
		assertThat(formValidation).isOk();
	}

	@Test
	void shouldBeOkIfEncodingIsValid() {
		// given
		IssuesRecorder.Descriptor descriptor = new IssuesRecorder.Descriptor();

		// when
		FormValidation formValidation = descriptor.doCheckSourceCodeEncoding("UTF-8");

		// then
		assertThat(formValidation).isOk();
	}

	@Test
	void shouldBeOkIfEncodingIsNotValid() {
		// given
		IssuesRecorder.Descriptor descriptor = new IssuesRecorder.Descriptor();

		// when
		FormValidation formValidation = descriptor.doCheckSourceCodeEncoding("SHITTY ENCODING");

		// then
		assertThat(formValidation).isError();
	}
}