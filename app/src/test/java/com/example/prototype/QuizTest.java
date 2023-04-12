package com.example.prototype;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultRegistry;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ComponentActivity;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHostHelper;
import androidx.fragment.app.FragmentController;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static org.mockito.Mockito.*;

public class QuizTest {
    @Mock
    TextView totalQuestionsTextView;
    @Mock
    TextView questionTextView;
    @Mock
    Button ansA;
    @Mock
    Button ansB;
    @Mock
    Button ansC;
    @Mock
    Button ansD;
    @Mock
    Button submitButton;
    @Mock
    AppCompatDelegate mDelegate;
    @Mock
    Resources mResources;
    @Mock
    FragmentController mFragments;
    @Mock
    LifecycleRegistry mFragmentLifecycleRegistry;
    //Field mContextAwareHelper of type ContextAwareHelper - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @Mock
    MenuHostHelper mMenuHostHelper;
    @Mock
    LifecycleRegistry mLifecycleRegistry;
    //Field mSavedStateRegistryController of type SavedStateRegistryController - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @Mock
    ViewModelStore mViewModelStore;
    @Mock
    ViewModelProvider.Factory mDefaultFactory;
    //Field mOnBackPressedDispatcher of type OnBackPressedDispatcher - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @Mock
    AtomicInteger mNextLocalRequestCode;
    @Mock
    ActivityResultRegistry mActivityResultRegistry;
    @Mock
    CopyOnWriteArrayList<Consumer<Configuration>> mOnConfigurationChangedListeners;
    @Mock
    CopyOnWriteArrayList<Consumer<Integer>> mOnTrimMemoryListeners;
    @Mock
    CopyOnWriteArrayList<Consumer<Intent>> mOnNewIntentListeners;
    @Mock
    CopyOnWriteArrayList<Consumer<MultiWindowModeChangedInfo>> mOnMultiWindowModeChangedListeners;
    @Mock
    CopyOnWriteArrayList<Consumer<PictureInPictureModeChangedInfo>> mOnPictureInPictureModeChangedListeners;
    @Mock
    SimpleArrayMap<Class<? extends ComponentActivity.ExtraData>, ComponentActivity.ExtraData> mExtraDataMap;
    @InjectMocks
    Quiz quiz;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() {
        quiz = new Quiz();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testQuestionIndexIsNeverMoreThanTotalQuestions() throws Exception{
        assertTrue(quiz.index <= quiz.totalQuestions);
    }
}