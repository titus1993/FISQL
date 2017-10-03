from django.conf.urls import url

from . import views

urlpatterns = [
    url(r'^$', views.index, name='index'),
    url(r'^ejecutarUsql', views.ejecutarSQL, name='ejecutarUsql'),
    url(r'^ejecutarReporte', views.ejecutarReporte, name='ejecutarReporte'),
    url(r'^ejecutarRestaurar', views.ejecutarRestaurar, name='ejecutarRestaurar'),
    url(r'^ejecutarBacup', views.ejecutarBacup, name='ejecutarBacup'),
    url(r'^login$', views.login, name='login')
]