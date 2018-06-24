package android.mobile.micmen.vehiclestest;

import android.arch.lifecycle.ViewModelProviders;
import android.mobile.micmen.vehiclestest.core.Resource;
import android.mobile.micmen.vehiclestest.features.vehicles.VehiclesActivity;
import android.mobile.micmen.vehiclestest.features.vehicles.VehiclesViewModel;
import android.mobile.micmen.vehiclestest.repository.VehiclesRepositoryImpl;
import android.support.test.annotation.UiThreadTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class VehicleViewModelTest {

    @Rule
    public ActivityTestRule<VehiclesActivity> mActivityRule = new ActivityTestRule<>(VehiclesActivity.class);

    @Test
    public void testResourceStateChangeWhenActivityLaunched() {
        VehiclesViewModel userViewModel = ViewModelProviders.of(mActivityRule.getActivity()).get(VehiclesViewModel.class);
        Assert.assertTrue(userViewModel.getVehiclesLiveData().getValue().getStatus() != Resource.Status.EMPTY);
    }

    @Test
    public void testVehiclesConsumerComplete(){
        VehiclesViewModel viewModel = ViewModelProviders.of(mActivityRule.getActivity()).get(VehiclesViewModel.class);
        TestObserver observer = new TestObserver();
        viewModel.getVehiclesRepository().getVehicles().subscribeWith(observer);
        observer.awaitTerminalEvent();
        observer.assertComplete();
    }

    @Test
    public void testSuccessStateAfter5Seconds() throws InterruptedException {
        VehiclesViewModel viewModel = ViewModelProviders.of(mActivityRule.getActivity()).get(VehiclesViewModel.class);
        TestObserver observer = new TestObserver();
        observer.await(5, TimeUnit.SECONDS);
        Assert.assertTrue(viewModel.getVehiclesLiveData().getValue().getStatus() == Resource.Status.SUCCESS);
    }

    @Test @UiThreadTest
    public void testSuccessOnVehiclesConsumerWithListRetrieved(){
        VehiclesViewModel viewModel = ViewModelProviders.of(mActivityRule.getActivity()).get(VehiclesViewModel.class);
        TestObserver observer = new TestObserver();
        VehiclesRepositoryImpl vehiclesRepository = mock(VehiclesRepositoryImpl.class);
        viewModel.setVehiclesRepository(vehiclesRepository);
        when(viewModel.getVehiclesRepository().getVehicles()).thenReturn(Observable.just(new ArrayList<>()));
        viewModel.getVehiclesRepository().getVehicles().subscribeWith(observer);
        viewModel.getVehicles();
        observer.assertNoErrors();
    }

    @Test @UiThreadTest
    public void testErrorOnVehiclesConsumerWithAnException(){
        VehiclesViewModel viewModel = ViewModelProviders.of(mActivityRule.getActivity()).get(VehiclesViewModel.class);
        TestObserver observer = new TestObserver();
        VehiclesRepositoryImpl vehiclesRepository = mock(VehiclesRepositoryImpl.class);
        viewModel.setVehiclesRepository(vehiclesRepository);
        Exception exception = new Exception("");
        when(viewModel.getVehiclesRepository().getVehicles()).thenReturn(Observable.error(exception));
        viewModel.getVehiclesRepository().getVehicles().subscribeWith(observer);
        viewModel.getVehicles();
        observer.assertError(exception);
    }
}
