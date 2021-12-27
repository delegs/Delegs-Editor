package de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.media.client.Video;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

import de.signWritingEditor.client.GWTClient.ui.general.widget.CloseButton.CloseListener;
import de.signWritingEditor.client.GWTClient.ui.general.widget.VideoRecorderCloseButton;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.ProgressBar;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditorSidebar;

public class VideoRecorderDialogBox extends ModalDialogBox {

	private AbsolutePanel mainPanel;
	private Label instructionLabel;
	private Button startButton;
	private Button stopButton;
	private FlowPanel videoPanel;
	private Video previewVideo;
	private Video recordedVideo;
	private Label logLabel;
	private static FormPanel uploadForm;
	private Button uploadSubmit;
	private VideoRecorderListener videoRecorderListener;
	private int counter;
	private Timer timer;
	private FlowPanel progressPanel;
	private ProgressBar progressBar;
	private Label progressText;

	public VideoRecorderDialogBox(VideoRecorderListener videoRecorderListener) {
		assert videoRecorderListener != null : "Precondition failed: videoRecorderListener != null";
		this.videoRecorderListener = videoRecorderListener;
		this.mainPanel = new AbsolutePanel();
		getCaption().setText(I18N.getVideoRecorderCaption());
		addStyleName("videoRecorderDialogBox");
		add(mainPanel);
		mainPanel.getElement().getStyle().setOverflow(Overflow.VISIBLE);
		mainPanel.getElement().getStyle().setPaddingTop(5, Unit.PX);

		instructionLabel = new HTML(I18N.getVideoRecordInstructions());
		instructionLabel.getElement().getStyle().setMarginBottom(10, Unit.PX);
		instructionLabel.getElement().getStyle().setMarginLeft(15, Unit.PX);
		instructionLabel.getElement().getStyle().setMarginRight(15, Unit.PX);
		instructionLabel.getElement().getStyle().setMarginTop(5, Unit.PX);
		instructionLabel.getElement().getStyle().setCursor(Cursor.DEFAULT);

		FlowPanel topButtonPanel = new FlowPanel();
		startButton = new Button(I18N.getStartVideoRecorder());
		startButton.getElement().setId("startButton");
		startButton.getElement().getStyle().setBackgroundImage("none");
		startButton.getElement().getStyle().setBackgroundColor("#e4e2e2c2");
		startButton.addStyleName("recordButton");
		startButton.getElement().getStyle().setMarginLeft(15, Unit.PX);
		startButton.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);

		stopButton = new Button(I18N.getStopVideoRecorder());
		stopButton.getElement().setId("stopButton");
		stopButton.getElement().getStyle().setBackgroundImage("none");
		stopButton.getElement().getStyle().setBackgroundColor("#e4e2e2c2");
		stopButton.addStyleName("recordButton");
		stopButton.getElement().getStyle().setMarginLeft(15, Unit.PX);
		stopButton.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);

		logLabel = new Label();
		logLabel.getElement().setId("logLabel");
		logLabel.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		logLabel.getElement().getStyle().setMarginLeft(10, Unit.PX);
		logLabel.getElement().getStyle().setCursor(Cursor.DEFAULT);

		videoPanel = new FlowPanel();
		previewVideo = Video.createIfSupported();
		previewVideo.getElement().setId("preview");
		recordedVideo = Video.createIfSupported();
		recordedVideo.getElement().setId("recording");

		if (previewVideo == null || recordedVideo == null) {
			assert previewVideo != null : "Precondition failed video not supported.";
			assert recordedVideo != null : "Precondition failed video not supported.";
		} else {
			previewVideo.setAutoplay(true);
			previewVideo.setMuted(true);
			recordedVideo.setControls(true);
			recordedVideo.setAutoplay(true);

			previewVideo.setSize("640px", "480px");
			recordedVideo.setSize("640px", "480px");
			previewVideo.addStyleName("recordVideo");
			recordedVideo.addStyleName("recordVideo");
		}

		progressPanel = new FlowPanel();
		progressBar = new ProgressBar(0.0, 1.0);
		progressBar.getElement().setId("progressBar");
		progressBar.addStyleName("videoRecorderDialogBoxProgressBar");
		progressText = new Label("0 %");
		progressText.getElement().setId("progressText");
		progressText.addStyleName("videoRecorderDialogBoxProgressText");
		progressPanel.add(progressBar);
		progressPanel.add(progressText);

		FlowPanel bottomButtonPanel = new FlowPanel();
		bottomButtonPanel.getElement().getStyle().setFloat(Float.RIGHT);
		bottomButtonPanel.getElement().getStyle().setMarginBottom(10, Unit.PX);
		bottomButtonPanel.getElement().getStyle().setMarginRight(15, Unit.PX);

		uploadForm = new FormPanel();
		uploadForm.setAction(DocumentEditorSidebar.videoSupplierUrl);
		uploadForm.setEncoding(FormPanel.ENCODING_MULTIPART);
		uploadForm.setMethod(FormPanel.METHOD_POST);
		uploadForm.getElement().setId("recordingUploadForm");
		uploadForm.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		uploadSubmit = new Button(I18N.getUpload());
		uploadSubmit.getElement().setAttribute("type", "submit");
		uploadSubmit.getElement().setId("recordingUploadButton");
		uploadSubmit.getElement().getStyle().setBackgroundImage("none");
		uploadSubmit.getElement().getStyle().setBackgroundColor("#e4e2e2c2");
		uploadSubmit.addStyleName("recordButton");

		VideoRecorderCloseButton closeButton = new VideoRecorderCloseButton(new CloseListener() {

			@Override
			public void onClose() {
				stopRecording();
				VideoRecorderDialogBox.this.hide();
				VideoRecorderDialogBox.this.removeFromParent();
				VideoRecorderDialogBox.this.videoRecorderListener.onCloseRecording();
			}
		});
		closeButton.addStyleName("videoRecorderCloseButton");

		videoPanel.add(previewVideo);
		videoPanel.add(recordedVideo);
		uploadForm.add(uploadSubmit);
		bottomButtonPanel.add(uploadForm);
		mainPanel.add(closeButton);
		mainPanel.add(instructionLabel);
		topButtonPanel.add(startButton);
		topButtonPanel.add(stopButton);
		topButtonPanel.add(logLabel);
		mainPanel.add(topButtonPanel);
		mainPanel.add(videoPanel);

		mainPanel.add(progressPanel);
		mainPanel.add(bottomButtonPanel);
	}

	private void handleUploadComplete(String videoUrl) {
		assert videoUrl != null : "Precondition failed: videoUrl != null";
		String url = videoUrl.replaceAll("<.*?>", "");
		videoRecorderListener.onUploadComplete(url);
		this.hide();
		this.removeFromParent();
		startButton.setText(I18N.getStartVideoRecorder());
	}

	private void updateCountdown(int counter) {
		if (counter < 4) {
			logLabel.setText(I18N.getVideoRecordingCountDown(counter));
			logLabel.getElement().getStyle().setColor("red");
		} else {
			initializeCountdown(counter);
			logLabel.getElement().getStyle().setColor("black");
		}
	}

	public void initializeCountdown(int counter) {
		this.counter = counter;
		logLabel.setText(I18N.getRecordingForXSeconds(this.counter));
		timer = new Timer() {
			@Override
			public void run() {
				VideoRecorderDialogBox.this.counter--;
				logLabel.setText(I18N.getRecordingForXSeconds(VideoRecorderDialogBox.this.counter));
				if (VideoRecorderDialogBox.this.counter < 1) {
					this.cancel();
				}
			}
		};
		timer.scheduleRepeating(1000);
	}

	private void stopTimer() {
		timer.cancel();
		logRecordingSuccessfull();
	}

	private void logRecordingSuccessfull() {
		stopButton.setEnabled(false);
		startButton.setEnabled(true);
		logLabel.setText(I18N.getVideoRecordingSuccessfull());
		logLabel.getElement().getStyle().setColor("green");
		startButton.setText(I18N.getReStartVideoRecorder());
		startButton.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
	}

	public void updateUploadProgress(double percentage) {
		assert percentage >= 0.0 : "Precondition: percentage >= 0.0";
		progressText.setVisible(true);

		if (percentage >= 1.0) {
			progressBar.setVisible(false);
			progressText.setVisible(false);
			videoRecorderListener.beforeOnUploadComplete();
		} else {
			progressBar.setVisible(true);
			progressText.setVisible(true);
		}
		progressBar.setProgress(percentage);

	}

	public void setProgressbarText(double percentage) {
		progressText.setText(progressBar.getText());
	}

	private native void stopRecording() /*-{
        var videoElem = $doc.getElementById("preview");
        var stream = videoElem.srcObject;
        if (stream !== null) {
            var tracks = stream.getTracks();

            tracks.forEach(function (track) {
                track.stop();
            });

            videoElem.srcObject = null;
        }
	}-*/;

	public void handleRecording() {
		jsHandleRecording(this);
	}

	private native void jsHandleRecording(VideoRecorderDialogBox videoDialog) /*-{
        var isRecording = true;
        var preview = $doc.getElementById("preview");
        var recording = $doc.getElementById("recording");
        var startButton = $doc.getElementById("startButton");
        var stopButton = $doc.getElementById("stopButton");
        var logElement = $doc.getElementById("logLabel");
        var uploadForm = $doc.getElementById("recordingUploadForm");
        var uploadButton = $doc.getElementById("recordingUploadButton");
        var progressBar = $doc.getElementById("progressBar");
        var progressText = $doc.getElementById("progressText");
        var isUserMediaOn = false;
        var recordingTimeMS = @de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditorSidebar::MAX_VIDEO_DURATION * 1000;
        var waitForReadyMS = 1000;

        recording.style.display = 'none';
        stopButton.style.display = 'none';
        progressBar.style.display = 'none';
        progressText.style.display = 'none';
        uploadButton.disabled = true;

        function getUserMedia() {
            $wnd.navigator.mediaDevices.getUserMedia = $wnd.navigator.mediaDevices.getUserMedia
                    || $wnd.navigator.mediaDevices.mozGetUserMedia
                    || $wnd.navigator.mediaDevices.webkitGetUserMedia
                    || $wnd.navigator.mediaDevices.oGetUserMedia
                    || $wnd.navigator.mediaDevices.msGetUserMedia;
            $wnd.navigator.mediaDevices.getUserMedia({
                video : true,
                audio : false
            }).then(
                    function (stream) {
                        preview.srcObject = stream;
                        preview.captureStream = preview.captureStream
                                || preview.mozCaptureStream
                                || preview.webkitCaptureStream
                                || preview.oCaptureStream
                                || preview.msCaptureStream;
                        return new Promise(function (resolve) {
                            preview.onplaying = resolve
                        });
                    }, function (err) {

                    });
        }

        if (isUserMediaOn === false) {
            getUserMedia();
            isUserMediaOn = true;
        }

        function waitForThreeSeconds() {
            videoDialog.@de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.VideoRecorderDialogBox::updateCountdown(I)(3);
            startButton.disabled = true;
            stopButton.disabled = false;
            return wait(waitForReadyMS)
                    .then(
                            function () {
                                videoDialog.@de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.VideoRecorderDialogBox::updateCountdown(I)(2);
                                return wait(waitForReadyMS)
                            })
                    .then(
                            function () {
                                videoDialog.@de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.VideoRecorderDialogBox::updateCountdown(I)(1);
                                return wait(waitForReadyMS)
                            });
        }

        function wait(delayInMS) {
            return new Promise(function (resolve) {
                setTimeout(resolve, delayInMS)
            });
        }

        var options;
        var file_ending;
        if (MediaRecorder.isTypeSupported('video/webm;codecs=vp8')) {
            options = {
                mimeType : 'video/webm; codecs=vp8',
                audo : false,
                video : true
            };
            file_ending = "webm";
        } else if (MediaRecorder.isTypeSupported('video/webm;codecs=vp9')) {
            options = {
                mimeType : 'video/webm; codecs=vp9',
                audo : false,
                video : true
            };
            file_ending = "webm";
        } else {
            options = {
                mimeType : 'video/mp4; codecs=h264',
                audo : false,
                video : true
            };
            file_ending = "mp4";
        }

        function startRecording(stream, lengthInMs) {
            startButton.style.display = 'none';
            stopButton.style.display = 'inline-block';
            recording.style.display = 'none';
            preview.style.display = 'block';

            var recorder = new MediaRecorder(stream, options);
            var data = [];

            recorder.ondataavailable = function (event) {
                data.push(event.data)
            };
            recorder.start();
            videoDialog.@de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.VideoRecorderDialogBox::updateCountdown(I)(5);

            var stopped = new Promise(function (resolve, reject) {
                recorder.onstop = resolve;
                recorder.onerror = function (event) {
                    reject(event.name)
                };
            });

            stopButton.onclick = function () {
                stopButton.disabled = true;
                if (recorder.state === 'recording') {
                    recorder.stop();
                    videoDialog.@de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.VideoRecorderDialogBox::stopTimer()();
                    stopButton.style.display = 'none';
                    showRecording();
                }
            };

            var recorded = wait(lengthInMs).then(function () {
                if (recorder.state === "recording") {
                    var recoderState = recorder.stop();
                    startButton.style.display = 'inline-block';
                    stopButton.style.display = 'none';
                    showRecording();
                    startButton.disabled = false;
                    return recoderState;
                }
                return false;
            });

            return stopped.then(function () {
                return data
            }, function () {
                return data
            });
        }

        function handleUpload(event, recordedBlob) {
            event.preventDefault();
            var formData = new FormData();
            formData.append('video', recordedBlob, 'neuesVideo.' + file_ending);
            var xhr = new XMLHttpRequest();
            xhr
                    .open(
                            'POST',
                            @de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditorSidebar::videoSupplierUrl,
                            true);
            xhr.onload = function (event) {
                if (xhr.status != 200) {
                } else {
                    videoDialog.@de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.VideoRecorderDialogBox::stopRecording()();
                    videoDialog.@de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.VideoRecorderDialogBox::handleUploadComplete(Ljava/lang/String;)(""+event.target.response);
                }
            };

            xhr.send(formData);

        }

        function updateUIAfterRecording(recordedChunks) {
            var recordedBlob = new Blob(recordedChunks, {
                type : "video/" + file_ending
            });
            recording.src = URL.createObjectURL(recordedBlob);

            uploadButton.disabled = false;
            uploadForm.onsubmit = function (event) {
                handleUpload(event, recordedBlob);
            };

            videoDialog.@de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.VideoRecorderDialogBox::logRecordingSuccessfull()();
            stopButton.style.display = 'none';
            startButton.style.display = 'inline-block';
        }

        function showRecording() {
            recording.style.display = 'block';
            preview.style.display = 'none';
        }

        startButton.onclick = function () {
            if (isUserMediaOn == false) {
                getUserMedia();
                isUserMediaOn = true;
            }
            recording.style.display = 'none';
            preview.style.display = 'block';
            waitForThreeSeconds()
                    .then(
                            function () {
                                startRecording(preview.captureStream(),
                                        recordingTimeMS).then(
                                        updateUIAfterRecording);
                            });
        };
	}-*/;

	public interface VideoRecorderListener {
		void onUploadComplete(String url);

		void beforeOnUploadComplete();
		
		void onCloseRecording();
	}

}
